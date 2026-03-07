import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DashboardEmployee } from './dashboard-employee';

describe('DashboardEmployee', () => {
  let component: DashboardEmployee;
  let fixture: ComponentFixture<DashboardEmployee>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DashboardEmployee],
    }).compileComponents();

    fixture = TestBed.createComponent(DashboardEmployee);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
