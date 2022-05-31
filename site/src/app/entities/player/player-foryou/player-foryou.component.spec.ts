import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PlayerForyouComponent } from './player-foryou.component';

describe('PlayerForyouComponent', () => {
  let component: PlayerForyouComponent;
  let fixture: ComponentFixture<PlayerForyouComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PlayerForyouComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PlayerForyouComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
