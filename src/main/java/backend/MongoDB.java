package backend;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class MongoDB {

    private final MongoClient mongoClient;
    private final MongoDatabase database;
    private final MongoCollection<Document> collection;

    public MongoDB() {
        // Inicializar conexión a MongoDB y obtener la colección necesaria
        mongoClient = MongoClients.create("mongodb://localhost:27017");
        database = mongoClient.getDatabase("Base_Datos_Paciente"); // Nombre de tu base de datos
        collection = database.getCollection("Datos_Paciente"); // Nombre de la colección de pacientes
    }

    // Método para insertar un nuevo paciente en la base de datos
    public boolean insertarPaciente(String email, String nombres, String cedula, String idEstudiante, String carrera,
                                    String fechaNacimiento, String genero, String etnia, String direccion,
                                    String telefono) {
        try {
            // Crear un documento con los datos del paciente
            Document paciente = new Document()
                    .append("email", email)
                    .append("nombres", nombres)
                    .append("cedula", cedula)
                    .append("idEstudiante", idEstudiante)
                    .append("carrera", carrera)
                    .append("fechaNacimiento", fechaNacimiento)
                    .append("genero", genero)
                    .append("etnia", etnia)
                    .append("direccion", direccion)
                    .append("telefono", telefono)
                    .append("informacionMedica", new Document()) // Añadir campo para información médica
                    .append("estiloVida", new Document()); // Añadir campo para estilo de vida

            // Insertar el documento en la colección
            collection.insertOne(paciente);

            return true; // Indicar que la inserción fue exitosa
        } catch (Exception e) {
            return false; // Indicar que hubo un error en la inserción
        }
    }

    // Método para insertar información médica de un paciente
    public boolean insertarInformacionMedica(String cedula, String alergias, String peso, String altura,
                                             String medicacion, String enfermedadesCardiacas,
                                             String antecedentesCardiacos, String padecimientos,
                                             String consumoTabaco, String consumoAlcohol) {
        try {
            // Crear el documento con los datos médicos
            Document informacionMedica = new Document()
                    .append("alergias", alergias)
                    .append("peso", peso)
                    .append("altura", altura)
                    .append("medicacion", medicacion)
                    .append("enfermedadesCardiacas", enfermedadesCardiacas)
                    .append("antecedentesFamiliares", antecedentesCardiacos)
                    .append("padecimientos", padecimientos)
                    .append("consumoTabaco", consumoTabaco)
                    .append("consumoAlcohol", consumoAlcohol);

            // Crear el filtro de búsqueda
            Document filtro = new Document("cedula", cedula);

            // Realizar la actualización en la colección
            collection.updateOne(filtro, new Document("$set", new Document("informacionMedica", informacionMedica)));

            return true; // Indicar que la actualización fue exitosa
        } catch (Exception e) {
            return false; // Indicar que hubo un error en la actualización
        }
    }

    // Método para insertar estilo de vida de un paciente
    public boolean insertarEstiloVida(String cedula, String actividadFisica, String alimentacionAdecuada, String horasSuenio,
                                      String calidadSuenio, String nivelEstres, String dolorPecho, String dificultadesRespirar, String mareosDesmayos) {
        try {
            // Crear el documento con los datos del estilo de vida
            Document estiloVida = new Document()
                    .append("actividadFisica", actividadFisica)
                    .append("alimentacion", alimentacionAdecuada)
                    .append("horasSuenio", horasSuenio)
                    .append("calidadSuenio", calidadSuenio)
                    .append("nivelEstres", nivelEstres)
                    .append("dolorPecho", dolorPecho)
                    .append("dificultadRespirar", dificultadesRespirar)
                    .append("mareosDesmayos", mareosDesmayos);

            // Crear el filtro de búsqueda
            Document filtro = new Document("cedula", cedula);

            // Realizar la actualización en la colección
            collection.updateOne(filtro, new Document("$set", new Document("estiloVida", estiloVida)));

            return true; // Indicar que la actualización fue exitosa
        } catch (Exception e) {
            return false; // Indicar que hubo un error en la actualización
        }
    }

    // Método para buscar un paciente por cédula
    public Document buscarPacientePorCedula(String cedula) {
        try {
            // Crear el filtro de búsqueda
            Document filtro = new Document("cedula", cedula);

            // Realizar la búsqueda en la colección
            Document paciente = collection.find(filtro).first();

            return paciente;
        } catch (Exception e) {
            return null; // Indicar que hubo un error en la búsqueda
        }
    }

    // Método para buscar la información médica de un paciente por cédula
    public Document buscarInformacionMedicaPorCedula(String cedula) {
        try {
            // Crear el filtro de búsqueda
            Document filtro = new Document("cedula", cedula);

            // Realizar la búsqueda en la colección y obtener solo la información médica
            Document paciente = collection.find(filtro).first();
            
            if (paciente != null) {
                return (Document) paciente.get("informacionMedica");
            } else {
                return null; // Indicar que no se encontró el paciente
            }
        } catch (Exception e) {
            return null; // Indicar que hubo un error en la búsqueda
        }
    }

    // Método para buscar el estilo de vida de un paciente por cédula
    public Document buscarEstiloVidaPorCedula(String cedula) {
        try {
            // Crear el filtro de búsqueda
            Document filtro = new Document("cedula", cedula);

            // Realizar la búsqueda en la colección y obtener solo el estilo de vida
            Document paciente = collection.find(filtro).first();

            if (paciente != null) {
                return (Document) paciente.get("estiloVida");
            } else {
                return null; // Indicar que no se encontró el paciente
            }
        } catch (Exception e) {
            return null; // Indicar que hubo un error en la búsqueda
        }
    }

    // Método para actualizar los datos de un paciente
    public boolean actualizarPaciente(String cedula, String nuevosNombres, String nuevaCedula, String nuevoIdEstudiante,
                                      String nuevaCarrera, String nuevaFechaNacimiento, String nuevoGenero,
                                      String nuevaEtnia, String nuevaDireccion, String nuevoTelefono) {
        try {
            // Crear el filtro de búsqueda
            Document filtro = new Document("cedula", cedula);

            // Crear el documento con los nuevos datos
            Document nuevosDatos = new Document()
                    .append("nombres", nuevosNombres)
                    .append("cedula", nuevaCedula)
                    .append("idEstudiante", nuevoIdEstudiante)
                    .append("carrera", nuevaCarrera)
                    .append("fechaNacimiento", nuevaFechaNacimiento)
                    .append("genero", nuevoGenero)
                    .append("etnia", nuevaEtnia)
                    .append("direccion", nuevaDireccion)
                    .append("telefono", nuevoTelefono);

            // Realizar la actualización en la colección
            collection.updateOne(filtro, new Document("$set", nuevosDatos));

            return true; // Indicar que la actualización fue exitosa
        } catch (Exception e) {
            return false; // Indicar que hubo un error en la actualización
        }
    }

    // Método para eliminar un paciente por cédula
    public boolean eliminarPacientePorCedula(String cedula) {
        try {
            // Crear el filtro de búsqueda
            Document filtro = new Document("cedula", cedula);

            // Eliminar el paciente de la colección
            collection.deleteOne(filtro);

            return true; // Indicar que la eliminación fue exitosa
        } catch (Exception e) {
            return false; // Indicar que hubo un error en la eliminación
        }
    }

    // Método para obtener todos los pacientes
    public List<Document> obtenerTodosLosPacientes() {
        try {
            // Inicializar lista para almacenar los pacientes
            List<Document> pacientes = new ArrayList<>();

            // Obtener todos los documentos de la colección
            try (MongoCursor<Document> cursor = collection.find().iterator()) {
                while (cursor.hasNext()) {
                    pacientes.add(cursor.next());
                }
            }

            return pacientes;
        } catch (Exception e) {
            return null; // Indicar que hubo un error al obtener los pacientes
        }
    }
}
