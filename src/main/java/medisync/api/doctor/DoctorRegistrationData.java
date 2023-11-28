package medisync.api.doctor;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import medisync.api.address.AddressData;

public record DoctorRegistrationData(
        @NotBlank
        String name,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String phone,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String npi,
        @NotNull
        Specialty specialty,
        @NotNull @Valid AddressData address) {

}
