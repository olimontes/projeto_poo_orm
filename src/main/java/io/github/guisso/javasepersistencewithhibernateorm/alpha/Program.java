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
package io.github.guisso.javasepersistencewithhibernateorm.alpha;

import io.github.guisso.javasepersistencewithhibernateorm.alpha.aluno.Aluno;
import io.github.guisso.javasepersistencewithhibernateorm.alpha.aluno.AlunoRepository;
import java.time.LocalDate;

/**
 * Runs tests of the "Alpha" version
 *
 * @author Luis Guisso &lt;luis dot guisso at ifnmg dot edu dot br&gt;
 * @version 0.1
 * @since 0.1, 2025-06-25
 */
public class Program {

    public static void main(String[] args) {
        // Object to be persisted
        Aluno aluno = new Aluno();

        // !!! ID should not be set!!!
        //aluno.setId(1234L);
        
        aluno.setMatricula(20250001);
        aluno.setNome("Ana Zaira");
        aluno.setNascimento(LocalDate.of(2000, 6, 1));

        AlunoRepository repository = new AlunoRepository();

        // Persistence
        repository.save(aluno);
    }
}
