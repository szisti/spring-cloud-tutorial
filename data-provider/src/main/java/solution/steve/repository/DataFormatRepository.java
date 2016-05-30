package solution.steve.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import solution.steve.domain.DataFormat;

@RepositoryRestResource
public interface DataFormatRepository extends PagingAndSortingRepository<DataFormat, Long> {
}
