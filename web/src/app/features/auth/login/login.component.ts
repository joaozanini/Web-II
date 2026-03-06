import { Component } from '@angular/core';

@Component({
  selector: 'app-login',
  standalone: true,
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  //
  togglePassword(){ 
  //
  const input_password = document.getElementById('password_input') as HTMLInputElement;
  const type_password = input_password.type;
  //
  const img_password = document.getElementById('icon_olho') as HTMLImageElement;
  //    
  if (type_password == "password") {
    //
    input_password.type = "text";
    img_password.src = "/assets/images/icone_olho_aberto.png";
    //  
  } else if (type_password == "text") {
    //
    input_password.type ="password";
    img_password.src = "/assets/images/icone_olho_fechado.png";

    //
  }
}
}
