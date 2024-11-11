import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LodgingListComponent } from './lodging-list.component';

describe('LodgingListComponent', () => {
  let component: LodgingListComponent;
  let fixture: ComponentFixture<LodgingListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LodgingListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LodgingListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
