import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {PostsUpdateComponent} from './post-update.component';

describe('PostsUpdateComponent', () => {
  let component: PostsUpdateComponent;
  let fixture: ComponentFixture<PostsUpdateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [PostsUpdateComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PostsUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
