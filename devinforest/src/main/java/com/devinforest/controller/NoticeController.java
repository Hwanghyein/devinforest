package com.devinforest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.devinforest.service.NoticeService;

@Controller
public class NoticeController {
	@Autowired private NoticeService noticeService;
}