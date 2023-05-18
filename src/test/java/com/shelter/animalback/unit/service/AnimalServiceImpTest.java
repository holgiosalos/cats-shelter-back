package com.shelter.animalback.unit.service;

import com.shelter.animalback.domain.Animal;
import com.shelter.animalback.model.AnimalDao;
import com.shelter.animalback.repository.AnimalRepository;
import com.shelter.animalback.service.AnimalServiceImp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

@ExtendWith(MockitoExtension.class)
public class AnimalServiceImpTest {
    @Mock
    private AnimalRepository animalRepository;

    @InjectMocks
    private AnimalServiceImp animalServiceImp;

    @Test
    public void testGetAll() {
        AnimalDao expectedAnimal = new AnimalDao();
        expectedAnimal.setId(1L);
        expectedAnimal.setName("Bigotes");
        expectedAnimal.setBreed("Siames");
        expectedAnimal.setGender("Male");
        expectedAnimal.setVaccinated(false);
        List<AnimalDao> expectedAnimalList = new ArrayList<AnimalDao>();
        expectedAnimalList.add(expectedAnimal);
        Mockito.when(animalRepository.findAll()).thenReturn(expectedAnimalList);

        List<Animal> actualAnimalList = animalServiceImp.getAll();

        assertThat(actualAnimalList, hasSize(expectedAnimalList.size()));
        Animal actualAnimal = actualAnimalList.get(0);
        assertThat(actualAnimal.getId(), equalTo(expectedAnimal.getId()));
        assertThat(actualAnimal.getName(), equalTo(expectedAnimal.getName()));
        assertThat(actualAnimal.getGender(), equalTo(expectedAnimal.getGender()));
        assertThat(actualAnimal.getBreed(), equalTo(expectedAnimal.getBreed()));
        assertThat(actualAnimal.isVaccinated(), equalTo(expectedAnimal.isVaccinated()));
    }
}