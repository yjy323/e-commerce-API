package com.project.api.repository.item;

import com.project.api.entity.item.ItemOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemOptionRepository extends JpaRepository<ItemOption, Long> {

}
