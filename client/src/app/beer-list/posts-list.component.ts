import { Component, OnInit } from '@angular/core';
import { BlogWebService, GiphyService } from '../shared';

@Component({
  selector: 'app-blog-web-list',
  templateUrl: './posts-list.component.html',
  styleUrls: ['./posts-list.component.css'],
  providers: [BlogWebService, GiphyService]
})
export class PostsListComponent implements OnInit {
  postsList: Array<any>;

  constructor(private blogWebService: BlogWebService, private giphyService: GiphyService) { }

  ngOnInit() {
    this.blogWebService.getAll().subscribe(
      data => {
        this.postsList = data;
        for (const posts of this.postsList) {
          this.giphyService.get(posts.name).subscribe(url => posts.giphyUrl = url);
        }
      },
      error => console.log(error)
    )
  }
}
