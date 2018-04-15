import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import {AppComponent} from './app.component';
import {PostsListComponent} from './post-list/post-list.component';
import {MatButtonModule, MatListModule, MatToolbarModule} from '@angular/material';
import {MatMenuModule} from '@angular/material/menu';
import {MatIconModule} from '@angular/material/icon';
import {ServiceWorkerModule} from '@angular/service-worker';
import {environment} from '../environments/environment';
import {RouterModule, Routes} from '@angular/router';
import {MatTableModule} from '@angular/material/table';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {PostsAddComponent} from "./post-add/post-add.component";
import {FormsModule} from '@angular/forms';
import {PostsUpdateComponent} from "./post-update/post-update.component";


const appRoutes: Routes = [
  {path: 'all', component: PostsListComponent},
  {path: 'add', component: PostsAddComponent},
  {path: 'update', component: PostsUpdateComponent},

];

@NgModule({
  declarations: [
    AppComponent,
    PostsListComponent,
    PostsAddComponent,
    PostsUpdateComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    MatButtonModule,
    MatListModule,
    MatToolbarModule,
    MatMenuModule,
    MatIconModule,
    MatTableModule,
    MatFormFieldModule,
    MatInputModule,
    FormsModule,
    BrowserAnimationsModule,
    RouterModule.forRoot(appRoutes,
      {enableTracing: true}
    ),
    ServiceWorkerModule.register(
      '/ngsw-worker.js', {enabled: environment.production}
    )
  ],
  providers: [],

  bootstrap: [AppComponent]
})
export class AppModule {
}
