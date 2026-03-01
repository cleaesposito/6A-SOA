package fr.insa.soa.RESTStudent;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("/students")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StudentResource {

    private static List<Student> students = new ArrayList<>(); //Stockage etudiants
    private static long counter = 1;

    @POST
    public Response createStudent(Student s) {
        s.setId(counter++);
        students.add(s);
        return Response.status(Response.Status.CREATED)
                       .entity(addHATEOAS(s))
                       .build();
    }

    @GET
    public List<Map<String, Object>> getAll() {
        List<Map<String, Object>> result = new ArrayList<>();
        for (Student s : students) {
            result.add(addHATEOAS(s));
        }
        return result;
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") long id) {
        Student s = findStudentById(id);
        if (s == null) return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(addHATEOAS(s)).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") long id, Student s) {
        Student existing = findStudentById(id);
        if (existing == null) return Response.status(Response.Status.NOT_FOUND).build();

        existing.setNom(s.getNom());
        existing.setPrenom(s.getPrenom());
        existing.setEmail(s.getEmail());
        existing.setEtablissement(s.getEtablissement());
        existing.setFiliere(s.getFiliere());
        existing.setCompetences(s.getCompetences());
        existing.setDisponibilites(s.getDisponibilites());
        existing.setNoteMoyenne(s.getNoteMoyenne());

        return Response.ok(addHATEOAS(existing)).build();
    }

    public Student findStudentById(long id) {
        for (Student s : students) {
            if (s.getId() == id) return s;
        }
        return null;
    }

    public Map<String, Object> addHATEOAS(Student s) {
        Map<String, Object> map = new HashMap<>();
        map.put("student", s);

        List<Link> links = new ArrayList<>();
        links.add(new Link("/api/students/" + s.getId(), "self"));
        links.add(new Link("/api/students/" + s.getId(), "update"));
        links.add(new Link("/api/students/" + s.getId(), "delete"));

        map.put("links", links);
        return map;
    }
}