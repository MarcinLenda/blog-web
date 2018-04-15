import {Component} from '@angular/core';
import {BlogWebService} from '../shared';
import {MatSnackBar} from "@angular/material";

@Component({
  selector: 'app-blog-web-list',
  templateUrl: 'post-add.component.html',
  styleUrls: ['post-add.component.css'],
  providers: [BlogWebService,MatSnackBar]
})

export class PostsAddComponent {

  constructor(private blogWebService: BlogWebService, public snackBar: MatSnackBar) { }

  addPosts(title: string, content: string) {
    const posts: Posts = {
      id: null,
      title: title,
      content: content
    };
    this.blogWebService.post(posts).subscribe(data => {
      this.snackBar.open("asdasd", "asdasd", {
        duration: 2000,
      });
    });
  }
}

export interface Posts {
  id: number;
  title: string;
  content: string;
}

