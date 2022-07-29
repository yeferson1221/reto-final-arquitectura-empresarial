import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GanadorRondaComponent } from './ganador-ronda.component';

describe('GanadorRondaComponent', () => {
  let component: GanadorRondaComponent;
  let fixture: ComponentFixture<GanadorRondaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GanadorRondaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GanadorRondaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
