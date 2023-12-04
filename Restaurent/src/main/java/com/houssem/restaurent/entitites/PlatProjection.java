package com.houssem.restaurent.entitites;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomPlat", types = { Plat.class })

public interface PlatProjection {
	public String getNomPlat();
}
