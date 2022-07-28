import { ComponentFixture, TestBed } from '@angular/core/testing';

import { JuegoSalaComponent } from './juego-sala.component';

describe('JuegoSalaComponent', () => {
  let component: JuegoSalaComponent;
  let fixture: ComponentFixture<JuegoSalaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ JuegoSalaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(JuegoSalaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
