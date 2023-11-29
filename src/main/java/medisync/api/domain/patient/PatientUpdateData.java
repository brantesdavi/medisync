package medisync.api.domain.patient;

import jakarta.validation.constraints.NotNull;
import medisync.api.domain.address.AddressData;

public record PatientUpdateData(
        @NotNull
        Long id,
        String name,
        String phone,
        String email,
        AddressData address) {
}
