package com.sjmatta.asgard.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

import com.sjmatta.asgard.values.ClientMessage;
import com.sjmatta.asgard.values.ServerMessage;

@Controller
public class MainController {

  private static Logger log = LoggerFactory.getLogger(MainController.class);

  @MessageMapping("/post")
  @SendToUser("/queue")
  public ServerMessage handleRequest(ClientMessage clientMessage) {
    log.debug("handleRequest: {}", clientMessage);
    ServerMessage serverMessage = new ServerMessage();
    serverMessage.setMessage("echo");
    return serverMessage;
  }
}
