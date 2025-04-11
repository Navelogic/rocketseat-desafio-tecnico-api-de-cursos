package com.github.navelogic.rdtac.Model;

import com.github.navelogic.rdtac.List.SimNaoList;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity(name = "Course")
@Table(name = "courses")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SimNaoList isActive;

    @ElementCollection
    @CollectionTable(name = "course_categories", joinColumns = @JoinColumn(name = "course_id"))
    @Column(name = "category")
    private List<String> categories;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at") //todo: Verificar se isso pode ser nullable = false.
    private LocalDateTime updatedAt;
}
