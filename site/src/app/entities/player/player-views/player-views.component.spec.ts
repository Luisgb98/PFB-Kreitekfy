import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PlayerViewsComponent } from './player-views.component';

describe('PlayerViewsComponent', () => {
  let component: PlayerViewsComponent;
  let fixture: ComponentFixture<PlayerViewsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PlayerViewsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PlayerViewsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
