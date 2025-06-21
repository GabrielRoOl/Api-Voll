package br.com.med.voll.api.controllers;

import br.com.med.voll.api.domain.model.endereco.Endereco;
import br.com.med.voll.api.domain.model.medico.Medico;
import br.com.med.voll.api.dto.DadosCadastroMedico;
import br.com.med.voll.api.dto.DadosDetalhamentoMedicoDTO;
import br.com.med.voll.api.dto.DadosEndereco;
import br.com.med.voll.api.enums.Especialidade;
import br.com.med.voll.api.repositories.MedicoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@AutoConfigureMockMvc
@SpringBootTest
@WithMockUser
@AutoConfigureJsonTesters
class MedicoControllerTest {

    @Autowired
    @MockBean
    private MedicoRepository repository;

    @Autowired
    private MockMvc mvc;

    @Autowired
    private JacksonTester<DadosCadastroMedico> dadosCadastroMedicoJson;

    @Autowired
    private JacksonTester<DadosDetalhamentoMedicoDTO> dadosDetalhamentoMedicoDTOJson;


    @Test
    @DisplayName("Deve devolver codigo http 400 quando está sendo passado parametros vazios")
    void cadastrar_cenario1() throws Exception {
        var response = mvc
                .perform(post("/medicos"))
                .andReturn().getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Deve devolver codigo http 400 quando falta o nome")
    void cadastrar_cenario2() throws Exception {

        // Cria os parametros que seram usados
        var dadosCadastro = new DadosCadastroMedico(
                "", // nome vazio
                "medico@voll.med",
                "61999999999",
                "123456",
                Especialidade.CARDIOLOGIA,
                dadosEndereco()
        );

        // Realiza a requisição
        var response = mvc
                .perform(post("/medicos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(dadosCadastroMedicoJson.write(dadosCadastro).getJson()))
                .andReturn().getResponse();

        // Verificação de status
        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Deve devolver codigo http 400 quando falta o email")
    void cadastrar_cenario3() throws Exception {

        // Cria os parametros que seram usados
        var dadosCadastro = new DadosCadastroMedico(
                "nome do médico",
                "", // email vazio
                "61999999999",
                "123456",
                Especialidade.CARDIOLOGIA,
                dadosEndereco()
        );

        // Realiza a requisição
        var response = mvc
                .perform(post("/medicos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(dadosCadastroMedicoJson.write(dadosCadastro).getJson()))
                .andReturn().getResponse();

        // Verificação de status
        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Deve devolver codigo http 400 quando o email é invalido: medico@")
    void cadastrar_cenario4() throws Exception {

        // Cria os parametros que seram usados
        var dadosCadastro = new DadosCadastroMedico(
                "nome do médico",
                "medico@", // email inválido
                "61999999999",
                "123456",
                Especialidade.CARDIOLOGIA,
                dadosEndereco()
        );

        // Realiza a requisição
        var response = mvc
                .perform(post("/medicos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(dadosCadastroMedicoJson.write(dadosCadastro).getJson()))
                .andReturn().getResponse();

        // Verificação de status
        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Deve devolver codigo http 400 quando o email é invalido: medico@.com")
    void cadastrar_cenario5() throws Exception {

        // Cria os parametros que seram usados
        var dadosCadastro = new DadosCadastroMedico(
                "nome do médico",
                "medico@.com", // email inválido
                "61999999999",
                "123456",
                Especialidade.CARDIOLOGIA,
                dadosEndereco()
        );

        // Realiza a requisição
        var response = mvc
                .perform(post("/medicos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(dadosCadastroMedicoJson.write(dadosCadastro).getJson()))
                .andReturn().getResponse();

        // Verificação de status
        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Deve devolver codigo http 400 quando o email é invalido: medicoemail.com")
    void cadastrar_cenario6() throws Exception {

        // Cria os parametros que seram usados
        var dadosCadastro = new DadosCadastroMedico(
                "nome do médico",
                "medicoemail.com", // email inválido
                "61999999999",
                "123456",
                Especialidade.CARDIOLOGIA,
                dadosEndereco()
        );

        // Realiza a requisição
        var response = mvc
                .perform(post("/medicos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(dadosCadastroMedicoJson.write(dadosCadastro).getJson()))
                .andReturn().getResponse();

        // Verificação de status
        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Deve devolver codigo http 400 quando o falta algum digito no telefone")
    void cadastrar_cenario7() throws Exception {

        // Cria os parametros que seram usados
        var dadosCadastro = new DadosCadastroMedico(
                "nome do médico",
                "medico@email.com",
                "6199999999", // telefone com um número a menos
                "123456",
                Especialidade.CARDIOLOGIA,
                dadosEndereco()
        );

        // Realiza a requisição
        var response = mvc
                .perform(post("/medicos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(dadosCadastroMedicoJson.write(dadosCadastro).getJson()))
                .andReturn().getResponse();

        // Verificação de status
        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Deve devolver codigo http 400 quando o telefone tem digitos a mais")
    void cadastrar_cenario8() throws Exception {

        // Cria os parametros que seram usados
        var dadosCadastro = new DadosCadastroMedico(
                "nome do médico",
                "medico@email.com",
                "619999999999", // telefone com um número a mais
                "123456",
                Especialidade.CARDIOLOGIA,
                dadosEndereco()
        );

        // Realiza a requisição
        var response = mvc
                .perform(post("/medicos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(dadosCadastroMedicoJson.write(dadosCadastro).getJson()))
                .andReturn().getResponse();

        // Verificação de status
        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Deve devolver codigo http 400 quando o telefone for vazio")
    void cadastrar_cenario9() throws Exception {

        // Cria os parametros que seram usados
        var dadosCadastro = new DadosCadastroMedico(
                "nome do médico",
                "medico@email.com",
                "", // telefone vazio
                "123456",
                Especialidade.CARDIOLOGIA,
                dadosEndereco()
        );

        // Realiza a requisição
        var response = mvc
                .perform(post("/medicos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(dadosCadastroMedicoJson.write(dadosCadastro).getJson()))
                .andReturn().getResponse();

        // Verificação de status
        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }


    @Test
    @DisplayName("Deve devolver codigo http 400 quando o crm possui menos de 4 caracteres")
    void cadastrar_cenario0() throws Exception {

        // Cria os parametros que seram usados
        var dadosCadastro = new DadosCadastroMedico(
                "nome do médico",
                "medico@email.com",
                "6199999999",
                "123", // crm menor que 4
                Especialidade.CARDIOLOGIA,
                dadosEndereco()
        );

        // Realiza a requisição
        var response = mvc
                .perform(post("/medicos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(dadosCadastroMedicoJson.write(dadosCadastro).getJson()))
                .andReturn().getResponse();

        // Verificação de status
        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Deve devolver codigo http 400 quando a especialização for nula")
    void cadastrar_cenario12() throws Exception {

        // Cria os parametros que seram usados
        var dadosCadastro = new DadosCadastroMedico(
                "nome do médico",
                "medico@email.com",
                "6199999999",
                "1234567", // crm maior que 6
                null,
                dadosEndereco()
        );

        // Realiza a requisição
        var response = mvc
                .perform(post("/medicos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(dadosCadastroMedicoJson.write(dadosCadastro).getJson()))
                .andReturn().getResponse();

        // Verificação de status
        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Deve devolver codigo http 400 quando o crm possui maior que 6 caracteres")
    void cadastrar_cenario11() throws Exception {

        // Cria os parametros que seram usados
        var dadosCadastro = new DadosCadastroMedico(
                "nome do médico",
                "medico@email.com",
                "6199999999",
                "1234567", // crm maior que 6
                Especialidade.CARDIOLOGIA,
                dadosEndereco()
        );

        // Realiza a requisição
        var response = mvc
                .perform(post("/medicos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(dadosCadastroMedicoJson.write(dadosCadastro).getJson()))
                .andReturn().getResponse();

        // Verificação de status
        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Deve devolver codigo http 201 quando informacoes estao validas")
    void cadastrar_cenario_tudo_em_orderm() throws Exception {

        // Cria os parametros que seram usados
        var dadosCadastro = new DadosCadastroMedico(
                "Nome do médico",
                "medico@voll.med",
                "61999999999",
                "123456",
                Especialidade.CARDIOLOGIA,
                dadosEndereco()
        );

        when(repository.save(any())).thenReturn(new Medico(dadosCadastro));

        // Injeta esses parametros
        var response = mvc
                .perform(post("/medicos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(dadosCadastroMedicoJson.write(dadosCadastro).getJson()))
                .andReturn().getResponse();

        var dadosDetalhamento = new DadosDetalhamentoMedicoDTO(
                null,
                dadosCadastro.nome(),
                dadosCadastro.email(),
                dadosCadastro.telefone(),
                dadosCadastro.crm(),
                dadosCadastro.especialidade(),
                new Endereco(dadosCadastro.endereco())
        );

        var jsonEsperado = dadosDetalhamentoMedicoDTOJson.write(dadosDetalhamento).getJson();

        assertThat(response.getContentAsString()).isEqualTo(jsonEsperado);
        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
    }

    private DadosEndereco dadosEndereco() {
        return new DadosEndereco(
                "rua xpto",
                "bairro",
                "00000000",
                "Brasilia",
                "DF",
                null
        );
    }

}