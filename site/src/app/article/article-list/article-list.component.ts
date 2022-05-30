import { Component, OnInit } from '@angular/core';
import { Article } from '../model/article.model';
import { ArticleService } from '../service/article.service';

@Component({
  selector: 'app-article-list',
  templateUrl: './article-list.component.html',
  styleUrls: ['./article-list.component.scss']
})
export class ArticleListComponent implements OnInit {
  articles: Article[] = [];

  constructor(private articleService: ArticleService) { }

  ngOnInit(): void {
    this.getArticles();
  }

  private getArticles(): void {
    this.articleService.getAllArticles().subscribe({
      next: (articleRequest) => {this.articles = articleRequest; },
      error: (err) => {this.handleError(err);}
    })
  }

  private handleError (error: any): void {
    console.log(error)
  }

}
