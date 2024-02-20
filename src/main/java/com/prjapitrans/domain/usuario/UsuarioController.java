package com.prjapitrans.domain.usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
/* import org.apache.logging.log4j.LogManager;
* import org.apache.logging.log4j.Logger;
*/
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UsuarioController {

  /*
   * private static final Logger LOGGER =
   * LogManager.getLogger(UsuarioController.class);
   */

  @Autowired
  private UsuarioService usuarioService;

  @GetMapping
  public List<tbctrusuario> getAll() {
    return usuarioService.getAlltbCtrUsuario();
  }

  @GetMapping("/login")
  public ResponseEntity<tbctrusuario> login(@RequestBody UsuarioRequest request) {
    return ResponseEntity.ok(usuarioService.getByLoginAndSenhaMD5(request.getLogin(), request.getSenha()));
  }

}
