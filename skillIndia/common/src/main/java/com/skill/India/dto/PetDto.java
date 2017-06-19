package com.skill.India.dto;

import java.sql.Timestamp;

import com.skill.India.common.BaseDto;

/**
 * The Class PetDto.
 */
public class PetDto extends BaseDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The name. */
	private final String name;

	/** The owner. */
	private final String owner;

	/** The species. */
	private final String species;

	/** The birth. */
	private final Timestamp birth;

	/** The death. */
	private final Timestamp death;

	/**
	 * Instantiates a new pet dto.
	 *
	 * @param name
	 *            the name
	 * @param owner
	 *            the owner
	 * @param species
	 *            the species
	 * @param birth
	 *            the birth
	 * @param death
	 *            the death
	 */
	public PetDto(String name, String owner, String species, Timestamp birth,
			Timestamp death) {
		super();
		this.name = name;
		this.owner = owner;
		this.species = species;
		this.birth = birth;
		this.death = death;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the owner.
	 *
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * Gets the species.
	 *
	 * @return the species
	 */
	public String getSpecies() {
		return species;
	}

	/**
	 * Gets the birth.
	 *
	 * @return the birth
	 */
	public Timestamp getBirth() {
		return birth;
	}

	/**
	 * Gets the death.
	 *
	 * @return the death
	 */
	public Timestamp getDeath() {
		return death;
	}

}
