package dev.com.thejungle.dao.interfaces;

import dev.com.thejungle.entity.ChatMessage;

import java.util.ArrayList;
import java.util.List;

public interface ChatDAOInt {

    ChatMessage createMessage(ChatMessage chatMessage);

    List<ChatMessage> getMessageGroupHistory(int groupId);

    List<ChatMessage> getMessageGlobalHistory();
}
