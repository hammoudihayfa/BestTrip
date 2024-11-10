import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddPassenger3Component } from './add-passenger3.component';

describe('AddPassenger3Component', () => {
  let component: AddPassenger3Component;
  let fixture: ComponentFixture<AddPassenger3Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddPassenger3Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddPassenger3Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
