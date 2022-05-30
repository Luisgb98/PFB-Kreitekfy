import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ArticleSongComponent } from './article-song.component';

describe('ArticleSongComponent', () => {
  let component: ArticleSongComponent;
  let fixture: ComponentFixture<ArticleSongComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ArticleSongComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ArticleSongComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
