import { ConsultaTipoComponent } from './tipo/consulta/consultaTipo.component';
import { CadastroTipoComponent } from './tipo/cadastro/cadastroTipo.component';
import { CadastroComponent } from './usuario/cadastro/cadastro.component';
import { HomeComponent } from './home/home.component';
import { MenuComponent } from './menu/menu.component';
import { UsuarioService } from './../services/usuario.service';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { routing } from './../app.routes';
import { FormsModule} from '@angular/forms';


import { AppComponent } from './app.component';
import { HttpModule } from '../../node_modules/@angular/http';
import { ConfigService } from '../services/config.service';
import { ConsultaComponent } from './usuario/consulta/consulta.component';


@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    HomeComponent,
    ConsultaComponent,
    CadastroComponent,
    CadastroTipoComponent,
    ConsultaTipoComponent
    
  ],
  imports: [
    BrowserModule,
    HttpModule,
    routing,
    FormsModule
  ],
  providers: [ConfigService, UsuarioService],
  bootstrap: [AppComponent]
})
export class AppModule { }
