package medisync.api.doctor;

import jakarta.validation.constraints.NotNull;
import medisync.api.address.AddressData;

public record DoctorUpdateData(
        @NotNull
        Long id,
        String name,
        String phone,
        AddressData address) {
}
