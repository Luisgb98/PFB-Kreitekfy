import { Component, Input, OnInit } from '@angular/core';
import { Article } from '../model/article.model';

@Component({
  selector: 'app-article-song',
  templateUrl: './article-song.component.html',
  styleUrls: ['./article-song.component.scss']
})
export class ArticleSongComponent implements OnInit {
  @Input() article?: Article;

  constructor() { }

  ngOnInit(): void {
  }

}
