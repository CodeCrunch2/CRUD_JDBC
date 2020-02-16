package service;

import dto.SkillDto;
import mapper.SkillMapper;
import model.Skill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import repository.SkillRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)

public class SkillServiceTest {

    @Spy
    @InjectMocks
    private SkillService skillService;

    @Mock
    private SkillMapper skillMapper;

    @Mock
    private SkillRepository skillRepository;


    @Test
    public void createSkillValidNameNotExistSkill() {
        String skillName = "SkillName";
        Skill skill = new Skill(skillName);
        skill.setId(1);

        SkillDto skillDto = new SkillDto();
        skillDto.setSkillName(skillName);
        skillDto.setId(1);

        doReturn(true).when(skillService).validateSkillName(skillName);
        doReturn(false).when(skillService).isExist(skillName);
        when(skillMapper.skillToDto(skill)).thenReturn(skillDto);

        assertEquals(skillDto, skillService.createSkill(skillName));
        verify(skillRepository).save(skill);

    }

    @Test
    public void createSkillNotValidName() {
        String skillName = "SN";
        SkillDto skillDto = new SkillDto();
        String message = "Name must be between 3 and 30 characters";
        skillDto.setErrorMessage(message);

        doReturn(false).when(skillService).validateSkillName(skillName);
        when(skillMapper.exceptionMessageToSkillDto(message)).thenReturn(skillDto);

        assertEquals(skillDto, skillService.createSkill(skillName));

    }

    @Test
    public void createSkillExistSkill() {
        String skillName = "SN";
        SkillDto skillDto = new SkillDto();
        String message = "Skill with this name exists";
        skillDto.setErrorMessage(message);
        doReturn(true).when(skillService).validateSkillName(skillName);
        doReturn(true).when(skillService).isExist(skillName);
        when(skillMapper.exceptionMessageToSkillDto(message)).thenReturn(skillDto);

        assertEquals(skillDto, skillService.createSkill(skillName));

    }

    @Test
    public void showSkillsIfSkillListNotEmpty() {
        Skill skill = new Skill("Skillname");
        List<Skill> skillList = Stream.of(skill).collect(Collectors.toList());
        SkillDto skillDto = new SkillDto();
        skillDto.setSkillName("Skillname");
        List<SkillDto> skillDtoList = Stream.of(skillDto).collect(Collectors.toList());
        when(skillRepository.getAll()).thenReturn(skillList);
        when(skillMapper.skillToDto(skill)).thenReturn(skillDto);
        assertEquals(skillDtoList, skillService.showSkills());
    }
    @Test
    public void showSkillsIfSkillListIsEmpty() {
        List<Skill> skillList = new ArrayList<>();
        when(skillRepository.getAll()).thenReturn(skillList);
        assertNull(skillService.showSkills());
    }

    @Test
    public void deleteSkillExistSkill() {
        String skillName = "SkillName";
        Skill skill = new Skill(skillName);
        skill.setId(1);

        SkillDto skillDto = new SkillDto();
        skillDto.setSkillName(skillName);
        skillDto.setId(1);
        doReturn(true).when(skillService).isExist(skillName);
        when(skillMapper.skillToDto(skill)).thenReturn(skillDto);
        assertEquals(skillDto, skillService.deleteSkill(skillName));
        verify(skillRepository).delete(skill);

    }
    @Test
    public void deleteSkillNotExistSkill() {
        String skillName = "SN";
        SkillDto skillDto = new SkillDto();
        String message = "Skill with this name does not exist";
        skillDto.setErrorMessage(message);
        doReturn(false).when(skillService).isExist(skillName);
        when(skillMapper.exceptionMessageToSkillDto(message)).thenReturn(skillDto);

        assertEquals(skillDto, skillService.deleteSkill(skillName));

    }

    @Test
    public void validateSkillNameValidName() {
        String skillName = "Name";
        assertTrue(skillService.validateSkillName(skillName));
    }

    @Test
    public void validateSkillNameNotValidName() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 40; i++) {
            stringBuilder.append("S");
        }

        assertFalse(skillService.validateSkillName("S"));
        assertFalse(skillService.validateSkillName(stringBuilder.toString()));
    }


    @Test
    public void isExistIntId() {
        Skill skill = new Skill("Name");
        skill.setId(1);
        List<Skill> skillList = new ArrayList<>();
        skillList.add(skill);
        int id = 1;

        when(skillRepository.getAll()).thenReturn(skillList);
        assertTrue(skillService.isExist(id));

    }

    @Test
    public void isExistIntIdNotExist() {
        Skill skill = new Skill("Name");
        skill.setId(1);
        List<Skill> skillList = new ArrayList<>();
        skillList.add(skill);
        int id = 2;

        when(skillRepository.getAll()).thenReturn(skillList);
        assertFalse(skillService.isExist(id));

    }
    @Test
    public void isExistIntIdEmptyList() {
        List<Skill> skillList = new ArrayList<>();
        int id = 1;

        when(skillRepository.getAll()).thenReturn(skillList);
        assertFalse(skillService.isExist(id));

    }

    @Test
    public void isExistStringName() {
        Skill skill = new Skill("Name");
        List<Skill> skillList = new ArrayList<>();
        skillList.add(skill);
        String name = "Name";

        when(skillRepository.getAll()).thenReturn(skillList);
        assertTrue(skillService.isExist(name));

    }

    @Test
    public void isExistStringNameNotExist() {
        Skill skill = new Skill("");
        List<Skill> skillList = new ArrayList<>();
        skillList.add(skill);
        String name = "Name";

        when(skillRepository.getAll()).thenReturn(skillList);
        assertFalse(skillService.isExist(name));

    }

    @Test
    public void isExistStringNameEmptyList() {
        List<Skill> skillList = new ArrayList<>();
        String name = "Name";

        when(skillRepository.getAll()).thenReturn(skillList);
        assertFalse(skillService.isExist(name));

    }


}