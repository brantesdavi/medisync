package medisync.api.domain.doctor;

import jakarta.validation.constraints.NotNull;
import medisync.api.domain.address.AddressData;

public record DoctorUpdateData(
        @NotNull
        Long id,
        String name,
        String phone,
        AddressData address) {
}
