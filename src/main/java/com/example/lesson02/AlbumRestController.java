package com.example.lesson02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson02.bo.AlbumBO;
import com.example.lesson02.model.Album;

@RestController
public class AlbumRestController {

	@Autowired
	private AlbumBO albumBO; // dependency injection (의존성 주입)
	
	@RequestMapping("/lesson02/ex01")
	public List<Album> ex01() {
		List<Album> albumList = albumBO.getAlbumList();
		return albumList;
	}
}
