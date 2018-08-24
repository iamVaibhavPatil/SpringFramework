package com.retroboard.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.retroboard.domain.Comment;
import com.retroboard.domain.CommentType;
import com.retroboard.repository.CommentRepository;
import com.retroboard.service.CommentService;

@RunWith(SpringRunner.class)
public class CommentServiceTest {

	@MockBean
	private CommentRepository commentRepository;
	
	private CommentService commentService;
	
	@Before
	public void init() {
		commentService = new CommentService(commentRepository);
	}
	
	@Test
	public void getAllCommentsForToday_HappyPath_ShouldReturn1Comment() {
		
		// Given
		Comment comment = new Comment();
		comment.setComment("Test");
		comment.setType(CommentType.PLUS);
		comment.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		List<Comment> comments = Arrays.asList(comment);
		LocalDate now = LocalDate.now();
		
		when(commentRepository.findByCreatedYearAndMonthAndDay(now.getYear(), now.getMonth().getValue(), now.getDayOfMonth())).thenReturn(comments);
		
		// When
		List<Comment> actualComments = commentService.getAllCommentsForToday();
		
		// Then
		verify(commentRepository, times(1)).findByCreatedYearAndMonthAndDay(now.getYear(), now.getMonth().getValue(), now.getDayOfMonth());
		assertThat(comments).isEqualTo(actualComments);
	}
	
	@Test
	public void saveAll_HappyPath_ShouldSave2Comments() {
		
		// Given
		Comment comment = new Comment();
		comment.setComment("Test Plus");
		comment.setType(CommentType.PLUS);
		comment.setCreatedBy("vaibhav");
		comment.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		
		Comment comment2 = new Comment();
		comment2.setComment("Test Star");
		comment2.setType(CommentType.STAR);
		comment2.setCreatedBy("neha");
		comment2.setCreatedDate(new Timestamp(System.currentTimeMillis()));		

		List<Comment> comments = Arrays.asList(comment, comment2);
		when(commentRepository.saveAll(comments)).thenReturn(comments);
		
		// When
		List<Comment> saved = commentService.saveAll(comments);
		
		// Then
		assertThat(saved).isNotEmpty();
		verify(commentRepository, times(1)).saveAll(comments);
		
	}
}
