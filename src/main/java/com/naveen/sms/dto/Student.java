package com.naveen.sms.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.naveen.sms.validation.Branch.ValidBranch;
import com.naveen.sms.validation.Department.ValidDepartment;
import com.naveen.sms.validation.phoneNo.ValidatePhoneNo;
import com.naveen.sms.validation.status.ValidStatus;

import com.naveen.sms.validation.year.ValidYear;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;


@Entity
@Table(name = "student_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 3, message = "Name should have at least 3 characters")
    private String name;

    @Email(message = "Email should be valid")
    @NotEmpty(message = "Email should not be empty")
    private String email;

    @NotEmpty(message = "Phone should not be empty")
    @Size(min = 10, max = 10, message = "Phone should have 10 digits")
    @ValidatePhoneNo
    private String phone;

    @NotNull(message = "Date of birth should not be empty")
    @Temporal(TemporalType.DATE)
    @PastOrPresent(message = "Date of birth should be in the past or present")
    @JsonFormat(pattern = "yyyy-MM-dd",shape = JsonFormat.Shape.STRING)
    private LocalDate dob;

    @NotEmpty(message = "Department should not be empty")
    @ValidDepartment
    private String department;

    @NotEmpty(message = "Branch should not be empty")
    @ValidBranch
    private String branch;

    @NotNull(message = "Year should not be empty")
    @Min(value = 1, message = "Year should be greater than 0")
    @Max(value = 4, message = "Year should be less than 5")
    @ValidYear
    @Column(name = "`YEAR`", nullable = false)
    private Integer year;

    @NotNull(message = "Semester should not be empty")
    @Min(value = 1, message = "Semester should be greater than 0")
    @Max(value = 8, message = "Semester should be less than 9")
    private Integer semester;

    @NotNull(message = "Credits completed should not be empty")
    @Min(value = 0, message = "Credits completed should be greater than or equal to 0")
    @Max(value = 200, message = "Credits completed should be less than or equal to 200")
    private Integer creditsCompleted;

    @NotNull(message = "Percentage should not be empty")
    @Min(value = 0, message = "Percentage should be greater than or equal to 0")
    @Max(value = 100, message = "Percentage should be less than or equal to 100")
    private Double percentage;

    @NotEmpty(message = "Status should not be empty")
    @ValidStatus
    private String status;

    @PastOrPresent
    @CreationTimestamp
    @Column(updatable = false)
    private OffsetDateTime createdAt;

    @PastOrPresent
    @UpdateTimestamp
    private OffsetDateTime updatedAt;
}
