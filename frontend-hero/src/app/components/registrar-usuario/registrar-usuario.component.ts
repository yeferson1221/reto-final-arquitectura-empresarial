import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AngularFireAuth } from '@angular/fire/compat/auth';
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';
import { FirebaseCodeErrorService } from 'src/app/services/firebase-code-error.service';
//rutas creadas
import { Jugador } from '../models/jugador';
import { JugadorService } from '../../services/jugador.service';

@Component({
  selector: 'app-registrar-usuario',
  templateUrl: './registrar-usuario.component.html',
  styleUrls: ['./registrar-usuario.component.css'],
})
export class RegistrarUsuarioComponent implements OnInit {
  registrarUsuario: FormGroup;
  loading: boolean = false;

  constructor(
    private fb: FormBuilder,
    private afAuth: AngularFireAuth,
    private toastr: ToastrService,
    private router: Router,
    private firebaseError: FirebaseCodeErrorService,
    private _serviceJugador: JugadorService
  ) {
    this.registrarUsuario = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]],
      repetirPassword: ['', Validators.required],
    });
  }

  ngOnInit(): void {}

  registrar() {

    const JUGADOR: Jugador = {
      nombre: this.registrarUsuario.get('email')?.value,
      mazo: this.registrarUsuario.get('n')?.value,
      turno: this.registrarUsuario.get('null')?.value,
      puntaje: this.registrarUsuario.get('null')?.value,
    }

    this._serviceJugador.guardarJugador(JUGADOR).subscribe(data => {
    }, error => {
      console.log(error);
      this.registrarUsuario.reset();
    })
   
    const email = this.registrarUsuario.value.email;
    const password = this.registrarUsuario.value.password;
    const repetirPassowrd = this.registrarUsuario.value.repetirPassword;

    console.log(this.registrarUsuario);
    if (password !== repetirPassowrd) {
      this.toastr.error(
        'Las contraseñas ingresadas deben ser las mismas',
        'Error'
      );
      return;
    }

    this.loading = true;
    this.afAuth
      .createUserWithEmailAndPassword(email, password)
      .then(() => {
        this.verificarCorreo();

      })
      .catch((error) => {
        this.loading = false;
        this.toastr.error(this.firebaseError.codeError(error.code), 'Error');
      });
  }

  verificarCorreo() {
    this.afAuth.currentUser
      .then((user) => user?.sendEmailVerification())
      .then(() => {
        this.toastr.info(
          'Le enviamos un correo electronico para su verificacion',
          'Verificar correo'
        );
        this.router.navigate(['/login']);
      });
  }

 


}
