/*
 * Copyright (C) 2025 Luis Guisso &lt;luis dot guisso at ifnmg dot edu dot br&gt;
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package io.github.guisso.javasepersistencewithhibernateorm.alpha.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

/**
 * Data source factory for MySQL DBRMS
 * 
 * DDL:
 * CREATE DATABASE gestaoescolar
 * DEFAULT CHARACTER SET utf8mb4
 * COLLATE utf8mb4_unicode_ci;
 *
 * @author Luis Guisso &lt;luis dot guisso at ifnmg dot edu dot br&gt;
 * @version 0.1
 * @since 0.1, 2025-06-25
 */
public class DataSourceFactory {

    private EntityManagerFactory emf;
    private final String PU_NAME = "gestaoEscolarPU";

    private static EntityManagerFactory getConnection() {
        return null;
    }

    public static EntityManager getEntityManager() {
        return null;
    }
}
