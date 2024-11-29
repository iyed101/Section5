package com.iyed.album;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.iyed.album.entities.Album;

import com.iyed.album.repos.AlbumRepository;


@SpringBootTest
class AlbumApplicationTests {

	@Autowired
	private AlbumRepository albumRepository;

	// @Test
	// public void testCreateAlbum() {
	// 	Album album = new Album("Angeles", new Date(), "Rap", 10);
	// 	albumRepository.save(album);
	// }
	
	// @Test
	// public void testAlbum()
	// {
	// 	Album album = albumRepository.findById(1L).get();		  
	// 	System.out.println(album);
	// }
	// @Test
	// public void testUpdateAlbum()
	// {
	// 	Album album = albumRepository.findById(1L).get();
	// 	album.setName("Notes");
	// 	albumRepository.save(album);
	// }
		
	// @Test
	// public void testDeleteAlbum()
	// {
	// 	albumRepository.deleteById(2L);;
	// }
	// @Test
	// public void testListerTousProduits()
	// {
	// 	List<Album>  albums = albumRepository.findAll();	 
	// 		for (Album a : albums)
	// 			{
	// 				System.out.println(a);
	// 			}	 
	// }
	// @Test
	// public void testfindByName() {
	// 	List<Album> albums = albumRepository.findByName("Angeles");
	// 	for (Album a : albums) {
	// 		System.out.println(a);
	// 	}
    // }
	// @Test
	// public void testfindByNameContains() {
	// 	List<Album> albums = albumRepository.findByNameContains("s");
	// 	for (Album a : albums) {
	// 		System.out.println(a);
	// 	}
	// }
	// @Test
	// public void testfindByNameGenre()
	// 	{
	// 	List<Album>  albs = albumRepository.findByNameGenre("Angeles", "Rap");
	// 		for (Album a : albs)
	// 			{
	// 				System.out.println(a);
	// 			}
			
	// 	}
	
	// @Test
	// public void testfindByArtist()
	// 	{
	// 		Artist artist = new Artist();
	// 		artist.setIdArtist(1L);
	// 		List<Album> albums = albumRepository.findByArtist(artist);
	// 		for (Album a : albums)
	// 			{
	// 				System.out.println(a);
	// 			}
	// 	}
	// @Test
	// public void testfindByArtistIdArtist()
	// 	{
	// 		List<Album> albums = albumRepository.findByArtistIdArtist(1L);
	// 		for (Album a : albums)
	// 			{
	// 				System.out.println(a);
	// 			}
	// 	}

	@Test
	public void testfindByOrderByNameAsc()
		{
			List<Album> albums = albumRepository.findByOrderByNameAsc();
			for (Album a : albums)
				{
					System.out.println(a);
				}
		}
	@Test
	public void testtrierAlbumNameGenre()
		{
			List<Album> albums = albumRepository.trierAlbumNameGenre();
			for (Album a : albums)
				{
					System.out.println(a);
				}
		}
}
