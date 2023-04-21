import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { HomeComponent } from './components/home/home.component';
import { LogoapComponent } from './components/logoap/logoap.component';
import { SocialesComponent } from './components/sociales/sociales.component';
import { BannerComponent } from './components/banner/banner.component';
import { ExperienciaComponent } from './components/experiencia/experiencia.component';
import { EducacionComponent } from './components/educacion/educacion.component';
import { NgCircleProgressModule } from 'ng-circle-progress';
import { HardnsoftskillsComponent } from './components/hardnsoftskills/hardnsoftskills.component';
import { ProyectosComponent } from './components/proyectos/proyectos.component';
import { FooterComponent } from './components/footer/footer.component';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { SobremiComponent } from './components/sobremi/sobremi.component';
import { LoginComponent } from './components/login/login.component';
import { FormsModule } from '@angular/forms';
import { InterceptorProvider, InterceptorService } from './service/interceptor-service';
import { NewExperienciaComponent } from './components/experiencia/new-experiencia/new-experiencia.component';
import { EditExperienciaComponent } from './components/experiencia/edit-experiencia/edit-experiencia.component';
import { NeweducacionComponent } from './components/educacion/neweducacion/neweducacion.component';
import { EditeducacionComponent } from './components/educacion/editeducacion/editeducacion.component';

@NgModule({ 
  declarations: [
    AppComponent,
    HomeComponent,
    HeaderComponent,
    LogoapComponent,
    SocialesComponent,
    BannerComponent,
    SobremiComponent,
    ExperienciaComponent,
    EducacionComponent,
    HardnsoftskillsComponent,
    ProyectosComponent,
    FooterComponent,
    LoginComponent,
    NewExperienciaComponent,
    EditExperienciaComponent,
    NeweducacionComponent,
    EditeducacionComponent
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgCircleProgressModule.forRoot({
      radius: 100,
      outerStrokeWidth: 16,
      innerStrokeWidth: 8,
      outerStrokeColor: "#78C000",
      innerStrokeColor: "#C7E596",
      animationDuration: 300,
    }),
    HttpClientModule,
    FormsModule,
    
  ],
  providers: [
    InterceptorProvider,


  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
