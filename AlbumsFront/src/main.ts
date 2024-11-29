import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';
import { provideHttpClient, withFetch } from '@angular/common/http';

import { AppModule } from './app/app.module';
import { bootstrapApplication } from '@angular/platform-browser';
import { AppComponent } from './app/app.component';

platformBrowserDynamic().bootstrapModule(AppModule, {
  ngZoneEventCoalescing: true
})
  .catch(err => console.error(err));
  // bootstrapApplication(AppComponent, {
  //   providers: [provideHttpClient(withFetch())]
  // });