import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Headers} from '@angular/http';
import { RequestOptions } from '@angular/http';
 
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/catch';


import {ConfigService} from './config.service';
import { Usuario } from './usuario.';

@Injectable()
export class UsuarioService {
    private baseUrlService:string = '';
    private headers:Headers;
    private options:RequestOptions;
 
    constructor(private http: Http,
                private configService: ConfigService) { 
 
        /**SETANDO A URL DO SERVIÇO REST QUE VAI SER ACESSADO */
        this.baseUrlService = configService.getUrlService() + '/usuario/';
 
        /*ADICIONANDO O JSON NO HEADER */
        this.headers = new Headers({ 'Content-Type': 'application/json;charset=UTF-8' });                
        this.options = new RequestOptions({ headers: this.headers });
    }
 
    /**CONSULTA TODOS OS USUARIOS CADASTRADOS */
    getUsuarios(){        
        return this.http.get(this.baseUrlService).map(res => res.json());
    }
 
    /**ADICIONA UM NOVO USUARIO */
    addDocumento(usuario: Usuario){
 
        return this.http.post(this.baseUrlService, JSON.stringify(usuario),this.options)
        .map(res => res.json());
    }
    /**EXCLUI UM USUARIO */
    excluirUsuario(id:number){
 
        return this.http.delete(this.baseUrlService + id).map(res => res.json());
    }
 
    /**CONSULTA UM USUARIO PELO ID */
    getUsuario(id:number){
 
        return this.http.get(this.baseUrlService + id).map(res => res.json());
    }

}