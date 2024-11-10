import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BookingSummary2Component } from './booking-summary2.component';

describe('BookingSummary2Component', () => {
  let component: BookingSummary2Component;
  let fixture: ComponentFixture<BookingSummary2Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BookingSummary2Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BookingSummary2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
