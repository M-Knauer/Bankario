package com.marcelo.main.projections;

import java.util.List;

public interface ClientMinProjection {

	String getName();
	String getCpf();
	String getEmail();
	List<TelefoneMinProjection> getTelefones();
}
