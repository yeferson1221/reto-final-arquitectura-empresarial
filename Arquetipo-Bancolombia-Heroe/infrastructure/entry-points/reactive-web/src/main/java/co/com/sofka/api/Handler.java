package co.com.sofka.api;

import co.com.sofka.model.game.Tablero;
import co.com.sofka.model.game.gateways.TableroRepository;
import co.com.sofka.usecase.createpet.CreatePetUseCase;
import co.com.sofka.usecase.deletapet.DeletePetUseCase;
import co.com.sofka.usecase.listarbyname.ListarbyNameUseCase;
import co.com.sofka.usecase.listarid.ListarIdPetUseCase;
import co.com.sofka.usecase.listarpet.ListarPetUseCase;
import co.com.sofka.usecase.updatepet.UpdatePetUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class Handler {
    private final TableroRepository tableroRepository;
    private final CreatePetUseCase createPetUseCase;

    private final ListarPetUseCase listarPetUseCase;

    private final ListarIdPetUseCase listarIdPetUseCase;

    private final UpdatePetUseCase updatePetUseCase;

    private final DeletePetUseCase deletePetUseCase;
    private final ListarbyNameUseCase listarbyNameUseCase;

    public Mono<ServerResponse> createPetPOSTUseCase(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(Tablero.class)
//                .flatMap(element -> createPetUseCase.createPet(element)) //es un flujo alterno-proceso de almacenamiento retorna otro flujo ya que el metodo del usecase guarda
                .flatMap(element -> ServerResponse.ok() //es el flujo que combierte la respuesta anterior a un body
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(createPetUseCase.createPet(element), Tablero.class));
    }


    public Mono<ServerResponse> listarGETUseCase(ServerRequest serverRequest) {
//        return serverRequest.bodyToMono(Pet.class)
//                .flatMap(element -> listarPetUseCase.listarPet())
//                .flatMap(element -> ServerResponse.ok()
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(listarPetUseCase.listarPet(), Tablero.class);
    }

    public Mono<ServerResponse> listForIdUseCase(ServerRequest serverRequest) {
        var id = serverRequest.pathVariable("id");
//        return serverRequest.bodyToMono(Pet.class)
////                        .flatMap(element -> listarIdPetUseCase.listarIdPet(id))
//                        .flatMap(e -> ServerResponse.ok()
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .body(listarIdPetUseCase.listarIdPet(id), Pet.class));
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(listarIdPetUseCase.listarIdPet(id), Tablero.class);
    }

    public Mono<ServerResponse> listarForNameUseCase(ServerRequest serverRequest) {
        var name = serverRequest.pathVariable("name");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(listarbyNameUseCase.listarByName(name), Tablero.class);
    }

    public Mono<ServerResponse> deleteGETUseCase(ServerRequest serverRequest) {
        var id = serverRequest.pathVariable("id");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON) // expone la respuesta en formato json depende dle mediatype
                .body(deletePetUseCase.deletePet(id), Tablero.class);
    }

    public Mono<ServerResponse> updatePOSTUseCase(ServerRequest serverRequest) {
        var id = serverRequest.pathVariable("id");
        return serverRequest.bodyToMono(Tablero.class)
//                .flatMap(e -> updatePetUseCase.updatePet(id, e))
                .flatMap(element -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(updatePetUseCase.updatePet(id, element), Tablero.class));
    }
}
