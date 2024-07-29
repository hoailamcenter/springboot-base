package com.base.auth.mapper;

import com.base.auth.dto.category.CategoryDto;
import com.base.auth.form.category.CreateCategoryForm;
import com.base.auth.form.category.UpdateCategoryForm;
import com.base.auth.model.Category;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-26T11:52:40+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 11.0.19 (Oracle Corporation)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public Category fromCreateCategory(CreateCategoryForm createCategoryForm) {
        if ( createCategoryForm == null ) {
            return null;
        }

        Category category = new Category();

        category.setName( createCategoryForm.getName() );
        category.setDescription( createCategoryForm.getDescription() );
        category.setImage( createCategoryForm.getImage() );
        category.setOrdering( createCategoryForm.getOrdering() );
        category.setKind( createCategoryForm.getKind() );

        return category;
    }

    @Override
    public void mappingForUpdateServiceCategory(UpdateCategoryForm updateServiceCategoryForm, Category category) {
        if ( updateServiceCategoryForm == null ) {
            return;
        }

        category.setName( updateServiceCategoryForm.getName() );
        category.setDescription( updateServiceCategoryForm.getDescription() );
        category.setImage( updateServiceCategoryForm.getImage() );
        category.setOrdering( updateServiceCategoryForm.getOrdering() );
    }

    @Override
    public CategoryDto fromEntityToCategoryDto(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryDto categoryDto = new CategoryDto();

        categoryDto.setId( category.getId() );
        categoryDto.setName( category.getName() );
        categoryDto.setDescription( category.getDescription() );
        categoryDto.setImage( category.getImage() );
        categoryDto.setOrdering( category.getOrdering() );
        categoryDto.setKind( category.getKind() );
        if ( category.getModifiedDate() != null ) {
            categoryDto.setModifiedDate( LocalDateTime.ofInstant( category.getModifiedDate().toInstant(), ZoneId.of( "UTC" ) ) );
        }
        if ( category.getCreatedDate() != null ) {
            categoryDto.setCreatedDate( LocalDateTime.ofInstant( category.getCreatedDate().toInstant(), ZoneId.of( "UTC" ) ) );
        }
        categoryDto.setStatus( category.getStatus() );

        return categoryDto;
    }

    @Override
    public List<CategoryDto> fromEntityToDtoList(List<Category> categories) {
        if ( categories == null ) {
            return null;
        }

        List<CategoryDto> list = new ArrayList<CategoryDto>( categories.size() );
        for ( Category category : categories ) {
            list.add( fromEntityToCategoryDto( category ) );
        }

        return list;
    }

    @Override
    public CategoryDto fromCategoryToCompleteDto(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryDto categoryDto = new CategoryDto();

        categoryDto.setId( category.getId() );
        categoryDto.setName( category.getName() );
        categoryDto.setDescription( category.getDescription() );
        categoryDto.setImage( category.getImage() );

        return categoryDto;
    }

    @Override
    public List<CategoryDto> fromCategoryToComplteDtoList(List<Category> categories) {
        if ( categories == null ) {
            return null;
        }

        List<CategoryDto> list = new ArrayList<CategoryDto>( categories.size() );
        for ( Category category : categories ) {
            list.add( fromCategoryToCompleteDto( category ) );
        }

        return list;
    }
}
