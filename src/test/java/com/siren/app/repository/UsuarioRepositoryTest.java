package com.siren.app.repository;

import com.siren.app.model.Usuario;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @BeforeAll
    void start() {

        usuarioRepository.deleteAll();

        usuarioRepository.save(new Usuario(0L, "Ana", "ana@email.com", "123456"));
        usuarioRepository.save(new Usuario(0L, "Bruno Qwerty", "bruno@email.com", "123456"));
        usuarioRepository.save(new Usuario(0L, "Carol Qwerty", "carol@email.com", "123456"));
        usuarioRepository.save(new Usuario(0L, "Dante Qwerty", "dante@email.com", "123456"));
    }

    @Test
    @DisplayName("Retorna 1 usuário")
    public void deveRetornarUmUsuario() {

        Optional<Usuario> usuario = usuarioRepository.findByUsuario("ana@email.com");
        assertTrue(usuario.get().getEmail().equals("ana@email.com"));
    }

    @Test
    @DisplayName("Retorna 3 usuários")
    public void deveRetornarTresUsuarios(){

        List<Usuario> listaDeUsuarios = usuarioRepository.findAllByNomeContainingIgnoreCase("Qwerty");
        assertEquals(3, listaDeUsuarios.size());
        assertTrue(listaDeUsuarios.get(0).getNome().equals("Bruno Qwerty"));
        assertTrue(listaDeUsuarios.get(1).getNome().equals("Carol Qwerty"));
        assertTrue(listaDeUsuarios.get(2).getNome().equals("Dante Qwerty"));
    }

    @AfterAll
    public void end(){
        usuarioRepository.deleteAll();
    }



}

