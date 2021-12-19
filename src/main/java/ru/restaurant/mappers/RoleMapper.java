package ru.restaurant.mappers;

import org.springframework.stereotype.Service;
import ru.restaurant.db.dao.Role;
import ru.restaurant.dto.RoleDto;

@Service
public class RoleMapper implements Mapper<RoleDto, Role> {
    @Override
    public RoleDto mapToDto(Role entity) {
        return RoleDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    @Override
    public Role mapToEntity(RoleDto dto) {
        return Role.builder()
                .id(dto.getId())
                .name(dto.getName())
                .build();
    }
}
