package com.retroboard.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.retroboard.domain.Comment;
import com.retroboard.domain.CommentType;
import com.retroboard.service.CommentService;

@Controller
public class CommentController {

	private final static Logger logger = LoggerFactory.getLogger(CommentController.class);
	private CommentService commentService;
	
	public CommentController(CommentService commentService) {
		this.commentService = commentService;
	}
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("time", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		List<Comment> allComments = commentService.getAllCommentsForToday();
		Map<CommentType, List<Comment>> groupedComments = allComments.stream().collect(Collectors.groupingBy(Comment::getType));
		model.addAttribute("starComments", groupedComments.get(CommentType.STAR));
		model.addAttribute("deltaComments", groupedComments.get(CommentType.DELTA));
		model.addAttribute("plusComments", groupedComments.get(CommentType.PLUS));
		return "comment";
	}
	
	@PostMapping("/comment")
	public String createComment(@RequestParam(name = "plusComment", required = false) String plusComment, 
			@RequestParam(name = "deltaComment", required = false) String deltaComment,
			@RequestParam(name = "starComment", required = false) String starComment) {
		
		List<Comment> comments = new ArrayList<Comment>();
		
		if(!StringUtils.isEmpty(plusComment)) {
			comments.add(getComment(plusComment, CommentType.PLUS));
		}
		if(!StringUtils.isEmpty(deltaComment)) {
			comments.add(getComment(deltaComment, CommentType.DELTA));
		}
		if(!StringUtils.isEmpty(starComment)) {
			comments.add(getComment(starComment, CommentType.STAR));
		}
		
		if(!comments.isEmpty()) {
			logger.info("Saved {}", commentService.saveAll(comments));
		}
		
		return "redirect:/";
	}
	
	private Comment getComment(String comment, CommentType commentType) {
		Comment commentObject = new Comment();
		commentObject.setComment(comment);
		commentObject.setType(commentType);
		return commentObject;
	}	
}