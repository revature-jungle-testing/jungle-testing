
 let cookie = JSON.parse(localStorage.getItem('userInfo'));
let userId = cookie.userId; // temporary 
let postId = 273; // temporary

// this is just a proof of concept and does not contain styling elements of the finished code
//assuming you are getting all the posts at once, this method will have to be called individually in a for loop for each post
//rough method to get the post image from database, needs to be updated to get the image format
//please refactor and modify as needed
async function getPostImage(){// the postId and imageFormat will probably have to be passed as parameters
  let url = "http://127.0.0.1:5000/post/image/" + postId;//post_id parameter
  console.log(url);
  let response = await fetch(url);
  console.log(response);

  if(response.status === 200){

      const image_text = await response.text();
      const image_Element = document.createElement('img');
      image_Element.src = image_text;//image_parameter
      document.getElementById("postImage").appendChild(image_Element);// also the element id will have to be dynamically created for each post so that the image is placed on the correct post
  }
}




// A basic create post without images for users.
async function createPost(){
    let postText = document.getElementById("postText");
    console.log(postText.value)
    let postJson = JSON.stringify({"userId":userId, "postText": postText.value, "imageFormat": "false"});
    let url = "http://127.0.0.1:8080/post"
    let thePost = await fetch(url, {
        method:"POST",
        headers:{'Content-Type': 'application/json'}, 
        body:postJson}).then(response => {return response.json()});
    console.log(thePost);
    getPost()
}



// A more complicated create post with images for users.
async function createPostWithImage() {
    let file    = document.getElementById('imageFile').files[0];
    let reader  = new FileReader();
    let base64gif;
    let postText = document.getElementById("postText");
    let postTextInput = postText.value;
    reader.addEventListener("load", async function () {
      base64gif = reader.result;
      base64gif.slice(14)
      console.log(base64gif.slice(23))


      if (base64gif.length < 1000000){
        // let postText = document.getElementById("postText");
        // console.log(postText.value)
        //Inserts the post into the post table
        let postJson = JSON.stringify({"userId":userId, "postText": postTextInput, "imageFormat": "true"});
        let url = "http://127.0.0.1:8080/post"
        let thePost = await fetch(url, {
            method:"POST",
            headers:{'Content-Type': 'application/json'}, 
            body:postJson}).then(response => {return response.json()});

        //Inserts the image into the post_image_table
        console.log(thePost["postId"]);
        let picPost = JSON.stringify({"picture":base64gif.slice(23)}, );
        let response = await fetch(
            "http://127.0.0.1:8080/post/image/" + thePost["postId"], {
              method: "POST",
              headers: {"Content-Type": "application/json"},
              body:base64gif.slice(23)
          });
          const imageText = await response.text();
          console.log(imageText)
          
      
      }
      else{
        alert("File Error")//need to replace this alert method later
      }
    }, false);
    
    if (file) {
      reader.readAsDataURL(file);
    }else if (document.getElementById("postText")){ // if there is no file put in, then the post is sent with the simpler method as long as there is text
      createPost()
    }else{
      alert("No Post entered.")//need to replace this alert method later
    }
    
    document.getElementById("createPostForm").reset();//because I don't know how to use PHP
    
  }


  async function getPost() {
    let response = await fetch("http://127.0.0.1:8080/user/post/" + userId, {
      method: "GET",
      mode: "cors",
    });
    if (response.status === 200) {
      let body = await response.json();
      console.log(body);
      populateData(body);
    }
    
  }


  async function test(commentPost){

    console.log(commentPost)
    let postText = document.getElementById("commentText" + commentPost).value;

    console.log(postText.value)
    let postJson = JSON.stringify({"post_id":commentPost,"user_id":userId, "comment_text": postText});
    let url = "http://127.0.0.1:8080/create/comment"
    let thePost = await fetch(url, {
        method:"POST",
        headers:{'Content-Type': 'application/json'}, 
        body:postJson}).then(response => {return response.json()});
        if(thePost.comment_text){
          alert("Comment Created")
        }
    console.log(thePost);
}
  
   async function populateData(responseBody) {

    const allpost = document.getElementById("post column");
    allpost.innerHTML = "";
    for (let post of responseBody) {
      let postBox = document.createElement('div');
      
      
      // postBox.innerHTML = `
      // <div class="overlap-group1" id="newPost${post.post_id}">
      // <p> ` + post.post_id + `</p>
      // <p> ` + post.user_id + `</p>
      // <p> ` + post.post_text + `</p> 
      // <p> Likes: ` + post.likes + `</p>
      // <p> ` + post.date_time_of_creation + `</p>
      // <button id="deletePost${post.post_id}" onclick="deleteGroupPost(${post.post_id})">Delete</button>
      // </div>`
      
      //add the poster image
      /*
      let url = "http://127.0.0.1:5000/user/image/" + post.user_id;
      let response = await fetch(url);
      let user_image_text;
      if(response.status === 200){
          user_image_text = await response.text();
        }
  */
      //get the post image\
      console.log(post.postId);
      
      let url = "http://127.0.0.1:8080/post/image/" + post.postId;
      console.log(url);
      let response = await fetch(url);
      console.log(response);
      
  
      if(response.status === 200){//if there is an image then this one, else the other one
        const image_text = await response.text();
        postBox.innerHTML = 
        `<div class = "post`+ post.postId +`" id = "post`+ post.postId + `">
        <div class="flex-row">
          <div class="list-group-item">
            <div class="username-1 valign-text-middle poppins-bold-cape-cod-20px">Username</div>
            <img class="feed-picture" src="`+ image_text +`" />
            <div class="feed-text-2 valign-text-middle poppins-medium-black-18px">`+ post.postText + `</div>
          </div>
        </div>
        <div onclick=""> Load Image </div>
        <input type="text" id="commentText`+ post.postId + `" placeholder="Comment">
        <input type="button" value="Comment" onclick="test(`+ post.postId + `)">
      </div>`
      }else{
        postBox.innerHTML = 
        `<div class = "post`+ post.postId +`" id = "post`+ post.postId + `" style=">
          <div class="flex-row">
            <div class="list-group-item">
              <div class="username-1 valign-text-middle poppins-bold-cape-cod-20px">Username</div>
              
              <div class="overlap-group-1">

              <div class="feed-text-2 valign-text-middle poppins-medium-black-18px ">`+ post.postText + `</div>
            </div>
          </div>
        </div>
        </div>
        </div>
        <div onclick=""> Load Image </div>
        <input type="text" id="commentText`+ post.postId + `" placeholder="Comment">
        <input type="button" value="Comment" onclick="test(`+ post.postId + `)">
        </div>`
      }
      allpost.appendChild(postBox);
    }
  
  
    
  }
  
  
  ///////
  async function deletePost(postID) {
    let deleteResponse = await fetch("http://127.0.0.1:8080/group_post/" + postId, {
      method: "DELETE"
    })
    console.log(deleteResponse)
    if (deleteResponse.status === 200) {
      document.getElementById("post" + postId).remove();
    }

  }