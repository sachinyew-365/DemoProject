package com.dummy.csv.controller;

import java.io.InputStream;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.dummy.csv.service.CsvJsonService;

@Path(value = "converter")
public class CsvController {

	@Inject
	CsvJsonService csvService;

	@POST
	@Path("/csv")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response convertToCsv(InputStream inputStream) throws Exception {
		StringBuilder retult = csvService.convertToCsv(inputStream);
		return Response.status(200).entity(retult.toString()).build();
	}

	@POST
	@Path("/json")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Response convertToJson(InputStream inputStream) throws Exception {
		String retult = csvService.convertToJson(inputStream);
		return Response.status(200).entity(retult).build();
	}
}