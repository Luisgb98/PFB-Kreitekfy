import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PlayerRatedComponent } from './player-rated.component';

describe('PlayerRatedComponent', () => {
  let component: PlayerRatedComponent;
  let fixture: ComponentFixture<PlayerRatedComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PlayerRatedComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PlayerRatedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
